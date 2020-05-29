package test;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class MyIText {

    /**
     * @param args
     */
    public static void main(String[] args) {
// TODO Auto-generated method stub

        System.out.println("MyIText");
        // 步骤 1: 创建一个document对象,大小为A4,上下左右边距都为36
        Document document = new Document(PageSize.A4, 35, 35, 20, 20);
        try {
            // 步骤 2:
            // 我们为document创建一个监听,并把PDF流写到文件中
            PdfWriter.getInstance(document, new FileOutputStream("d://MyIText.pdf"));

            // 步骤 3:打开文档
            document.open();

            // pdf文档中中文字体的设置,注意一定要添加iTextAsian.jar包
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);//加入document:
            Font FontChinese1 = new Font(bfChinese, 10, Font.NORMAL);//加入document:
            Font FontChinese2 = new Font(bfChinese, 8, Font.NORMAL);//加入document:

            // 创建章节对象
            Paragraph title1 = new Paragraph("PDF推荐表大标题", FontChinese);
            document.add(title1);

            Paragraph title2 = new Paragraph("编号: AAA000001", FontChinese1);
            document.add(title2);

            Paragraph title3 = new Paragraph("■ 推荐单位", FontChinese1);
            document.add(title3);

            // 创建一个有2列的表格,它们之间的相关比率为 15%,85%
            float[] widths = {0.15f, 0.85f};
            PdfPTable table = new PdfPTable(widths);

            table.setWidthPercentage(100);//table100%

            //第一行
            PdfPCell cell = new PdfPCell(new Paragraph("单位名称", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table.addCell(cell);

            cell = new PdfPCell(new Paragraph("15%", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table.addCell(cell);
            //第二行
            cell = new PdfPCell(new Paragraph("单位性质(勾选)", FontChinese1));
            cell.setFixedHeight(45);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(10);
            table.addCell(cell);

            String cc = "";
            String cc1 = "□ 产业研发企业 ";
            String cc2 = "□ 产品制造企业 ";
            String cc3 = "□ 设计公司 ";
            String cc4 = "□ 院校 ";
            String cc5 = "□ 其他服务机构 ";
            String cc6 = "□ 设计师 ";

            String[] characters = "1,2,5".split(",");
            for (int i = 0; i < characters.length; i++) {
                if (characters[i].equals("1")) {
                    cc1 = "■ 产业研发企业 ";
                } else if (characters[i].equals("2")) {
                    cc2 = "■ 产品制造企业 ";
                } else if (characters[i].equals("3")) {
                    cc3 = "■ 设计公司 ";
                } else if (characters[i].equals("4")) {
                    cc4 = "■ 院校 ";
                } else if (characters[i].equals("5")) {
                    cc5 = "■ 其他服务机构 ";
                } else if (characters[i].equals("6")) {
                    cc6 = "■ 设计师 ";
                }
            }
            cc = cc1 + cc2 + cc3 + "" + cc4 + cc5 + cc6;


            cell = new PdfPCell(new Paragraph(cc, FontChinese2));
            cell.setFixedHeight(45);
            cell.setPaddingLeft(25);
            cell.setPaddingTop(10);
            table.addCell(cell);

            //Image png = Image.getInstance("f:/http_imgload.jpg");//图片的地址
            //cell.setImage(png);
            table.addCell(cell);

            // 把定义好的表格增加到文档中
            document.add(table);

            Paragraph title4 = new Paragraph("■ 联系人", FontChinese1);
            document.add(title4);

            // 创建一个有4列的表格,它们之间的相关比率为 15%,40%,15%,30%
            float[] widths1 = {0.15f, 0.4f, 0.15f, 0.3f};
            PdfPTable table1 = new PdfPTable(widths1);
            table1.setWidthPercentage(100);//table100%

            //第一行
            cell = new PdfPCell(new Paragraph("姓名", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(30);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("珊珊", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("性别", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(30);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("女", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            //第二行
            cell = new PdfPCell(new Paragraph("单位", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(30);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("广州汉和", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("职位", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(30);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("程序员", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            //第三行
            cell = new PdfPCell(new Paragraph("联系电话", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("13111111111", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("电子邮件", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph(" aliyunzixun@xxx.com", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            //第四行
            cell = new PdfPCell(new Paragraph("通讯地址", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("东方之珠花园", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            cell.setColspan(3);
            table1.addCell(cell);

            //第五行
            cell = new PdfPCell(new Paragraph("身份证号", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("450821111111171722", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            cell.setColspan(3);
            table1.addCell(cell);

            // 把定义好的表格增加到文档中
            document.add(table1);

            Paragraph title5 = new Paragraph("■ 建议项目设置", FontChinese1);
            document.add(title5);

            // 创建一个有2列的表格,它们之间的相关比率为 15%,85%
            float[] widths2 = {0.15f, 0.85f};
            PdfPTable table2 = new PdfPTable(widths2);
            table2.setWidthPercentage(100);//table100%

            //第一行
            cell = new PdfPCell(new Paragraph("项目名称", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table2.addCell(cell);

            cell = new PdfPCell(new Paragraph("机器猫", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table2.addCell(cell);

            //第二行
            cell = new PdfPCell(new Paragraph("项目领域", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table2.addCell(cell);

            cell = new PdfPCell(new Paragraph("信息产业", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table2.addCell(cell);

            //第二行
            cell = new PdfPCell(new Paragraph("推荐理由(可附页说明)", FontChinese1));
            cell.setFixedHeight(270);
            cell.setPaddingLeft(12);
            cell.setPaddingTop(110);
            table2.addCell(cell);

            table2.addCell(new Paragraph("项目开发意向/建议项目创新性说明项目社会价值说明产业化前景说明产业化基础说明", FontChinese2));

            //第三行
            cell = new PdfPCell(new Paragraph("单位签章(个人签章)", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(20);
            cell.setPaddingTop(6);
            table2.addCell(cell);

            cell = new PdfPCell(new Paragraph("", FontChinese1));
            cell.setFixedHeight(25);
            cell.setPaddingLeft(5);
            cell.setPaddingTop(6);
            table2.addCell(cell);

            //第四行
            cell = new PdfPCell(new Paragraph("组委会意见", FontChinese1));
            cell.setFixedHeight(60);
            cell.setPaddingLeft(15);
            cell.setPaddingTop(20);
            table2.addCell(cell);

            table2.addCell(new Paragraph("喔喔喔喔喔", FontChinese1));

            // 把定义好的表格增加到文档中
            document.add(table2);

        } catch (Exception de) {
            de.printStackTrace();
        }
            // 步骤 5:关闭文档
        document.close();
    }


}