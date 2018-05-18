package solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by leiyang on 2018/5/18 0018 下午 5:34
 */
public class SolrClientTest {
    private SolrClient client;
    private String url;

    @Before
    public void init(){
        url = "http://192.168.1.124:8983/solr/mycollections";
        client = new HttpSolrClient.Builder(url).build();
    }


    public boolean saveSolrArticle(Article article){
        DocumentObjectBinder binder = new DocumentObjectBinder();
        SolrInputDocument doc = binder.toSolrInputDocument(article);
        try {
            client.add(doc);
            System.out.println(client.commit());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Test
    public void Test1(){
        Article article = new Article();
        article.setId("123456");
        article.setTitle(new String[] {"测试solrtesttesttesttest"});
        article.setAuthor(new String[]{"lylylylylylylylylyl"});
        article.setTime(new Date[]{new Date()});
        article.setInfo(new String[]{"测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试"});
        saveSolrArticle(article);
    }

    @Test
    public void Test2(){
        SolrQuery query = new SolrQuery();
        query.setQuery("lylylylylylylylylyl");
        QueryResponse rsp = null;
        try {
            rsp = client.query(query);
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
        assert rsp != null;
        List<Article> articleList = rsp.getBeans(Article.class);
        System.out.println(articleList);
    }
}
