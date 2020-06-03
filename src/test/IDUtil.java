package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDUtil {

    private static final Logger logger = LoggerFactory.getLogger(IDUtil.class);

    private static final Pattern PATTERN_HOSTNAME = Pattern.compile("^.*\\D+([0-9]+)$");

    private static final Pattern PATTERN_LONG_ID = Pattern.compile("^([0-9]{15})([0-9a-f]{32})([0-9a-f]{3})$");

    private static final long OFFSET = LocalDate.of(2020, 6, 3).atStartOfDay(ZoneId.of("Z")).toEpochSecond();

    private static final long MAX_NEXT = 0b11111_11111111_111L;

    private static final long SHARD_ID = getServerIdAsLong();

    private static long offset = 0;

    private static long lastEpoch = 0;

    private static long getServerIdAsLong() {
        try {
            String hostname = InetAddress.getLocalHost().getHostName();
            Matcher matcher = PATTERN_HOSTNAME.matcher(hostname);
            if (matcher.matches()) {
                long n = Long.parseLong(matcher.group(1));
                if (n >= 0 && n < 8) {
                    logger.info("detect server id from host name {}: {}.", hostname, n);
                    return n;
                }
            }
        } catch (UnknownHostException e) {
            logger.warn("unable to get host name. set server id = 0.");
        }
        return 0;
    }

    public static long nextId() {
        return nextId(System.currentTimeMillis() / 1000);
    }

    public static long nextId(long epochSecond) {

        if (epochSecond < lastEpoch) {
            logger.warn("clock is back: " + epochSecond + " from previous:" + lastEpoch);
            epochSecond = lastEpoch;
        }


        if (epochSecond != lastEpoch) {
            lastEpoch = epochSecond;
            reset();
        }

        offset++;
        long next = offset & MAX_NEXT;
        if (next == 0) {
            logger.warn("maximum id reached in 1 second in epoch: " + epochSecond);
            return nextId(epochSecond + 1);
        }

        return generateId(SHARD_ID, epochSecond, next);
    }

    private static long generateId(long shardId, long epochSecond, long next) {
        return shardId << 48 | (epochSecond - OFFSET) << 16 | next;
    }

    private static void reset() {
        offset = 0;
    }


//    public static long stringIdToLongId(String stringId) {
//        // a stringId id is composed as timestamp (15) + uuid (32) + serverId (000~fff).
//        Matcher matcher = PATTERN_LONG_ID.matcher(stringId);
//        if (matcher.matches()) {
//            long epoch = Long.parseLong(matcher.group(1)) / 1000;
//            String uuid = matcher.group(2);
//            byte[] sha1 = HashUtil.sha1AsBytes(uuid);
//            long next = ((sha1[0] << 24) | (sha1[1] << 16) | (sha1[2] << 8) | sha1[3]) & MAX_NEXT;
//            long serverId = Long.parseLong(matcher.group(3), 16);
//            return generateId(epoch, next, serverId);
//        }
//        throw new IllegalArgumentException("Invalid id: " + stringId);
//    }

    public static void main(String[] args) throws UnknownHostException {
        for (int i = 0; i < 1000; i++) {
            System.out.println(IDUtil.nextId());
        }
    }
}
