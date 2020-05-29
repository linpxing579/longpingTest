package test;

import bean.User;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class SolrTest {

    private static final String SORL_URL = "http://localhost:8983/solr/user";


    public static SolrClient getSolrClient(String solrName) {
        String solrUrl = SORL_URL;

        HttpSolrClient.Builder solrClient = new HttpSolrClient.Builder(solrUrl);

        return solrClient.build();

    }

    @Test
    public void testAdd() throws IOException, SolrServerException {
        SolrClient solrClient = getSolrClient("user");

        User user = new User();
        user.setId("1");
        user.setName("张三");
//        user.setSex("男");
        solrClient.addBean(user);

        solrClient.commit();

        solrClient.close();
    }


    @Test
    public void testQuery() throws IOException, SolrServerException {
        SolrClient solrClient = getSolrClient("");
        SolrQuery solrQuery = new SolrQuery("*:*");
        solrQuery.setQuery("id:1");     //设置查询条件
        solrQuery.setFields("name");    //设置返回字段
        solrQuery.setSort(new SolrQuery.SortClause("id", SolrQuery.ORDER.asc));   //排序
//        solrQuery.setStart(1);    //分页参数
//        solrQuery.setRows(2);     //分页参数

        QueryResponse response = solrClient.query(solrQuery);

        System.out.println(response.getBeans(User.class));

        SolrDocumentList solrDocuments = response.getResults();

        for (SolrDocument document : solrDocuments) {
            String name = document.getFieldValue("name").toString();
            System.out.println(name);
        }

        solrClient.close();
    }


    @Test
    public void testDelete() throws IOException, SolrServerException {
        SolrClient solrClient = getSolrClient("");

        solrClient.deleteById("1");

        solrClient.commit();

        solrClient.close();
    }

    @Test
    public void testAdd2() throws IOException, SolrServerException {
        SolrClient solrClient = getSolrClient("");

        for (int i = 0; i < 100; i++) {
            SolrInputDocument solrInputDocument = new SolrInputDocument();
            solrInputDocument.setField("id", i);
            solrInputDocument.setField("name", i);

            solrClient.add(solrInputDocument);
        }

        solrClient.commit();
        solrClient.close();
    }
}
