package com.example.library.manager;

import android.content.Context;

import com.example.library.Myapplication;
import com.example.library.model.bookmodel;
import com.example.library.model.bookmodelDao;
import com.example.library.utils.Datautils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class bookDaoManager {
    private Context mContext;
    private bookmodelDao mbooksModelDao;

    public bookDaoManager(Context context) {
        this.mContext = context;
//        获取DAO实例
        mbooksModelDao = Myapplication.mdaosession.getBookmodelDao();

    }
    public void insertallbooks () {
        String json = Datautils.getJson("books.json", mContext);
//        如果不想因为重复添加数据而导致崩溃,可以使用insertOrReplaceInTx API
//        mGoodsModelDao.insertInTx(DataUtils.getGoodsModels(json));
        mbooksModelDao.insertOrReplaceInTx(Datautils.getbookmodels(json));
    }
    public void insert(String namestr, String authorstr, String pressstr, String pagestr, String pricestr, String scorestr, String datestr, String isbNstr, String linkstr, String contentstr) {
        bookmodel bookmodel = getBookmodel(namestr, authorstr, pressstr, pagestr, pricestr, scorestr, datestr, isbNstr, linkstr, contentstr);
        mbooksModelDao.insertOrReplaceInTx(bookmodel);
    }

    private bookmodel getBookmodel(String namestr, String authorstr, String pressstr, String pagestr, String pricestr, String scorestr, String datestr, String isbNstr, String linkstr, String contentstr) {
        bookmodel bookmodel=new bookmodel();
        bookmodel.setLink(linkstr);
        bookmodel.setPage(pagestr);
        bookmodel.setName(namestr);
        bookmodel.setAuthor(authorstr);
        bookmodel.setPress(pressstr);
        bookmodel.setContent_description(contentstr);
        bookmodel.setPrice(pricestr);
        bookmodel.setDate(datestr);
        bookmodel.setScore(scorestr);
        bookmodel.setISBN(isbNstr);
        return bookmodel;
    }

    public List<bookmodel> querybooks () {
        QueryBuilder<bookmodel> result = mbooksModelDao.queryBuilder();
        result = result.orderAsc(bookmodelDao.Properties.Id);
        return result.list();

    }
    public List<bookmodel> queryByName(String Name) {
        return  mbooksModelDao
                .queryBuilder()
                .where(bookmodelDao.Properties.Name.eq(Name))
                .list();
    }

    public void updatebookInfo (bookmodel model) {
        mbooksModelDao.update(model);
        mbooksModelDao.updateInTx();
    }
    public  void saveData(String namestr, String authorstr, String pressstr, String pagestr, String pricestr, String scorestr, String datestr, String isbNstr, String linkstr, String contentstr) {

        bookmodel model=getBookmodel(namestr,authorstr,pressstr,pagestr,pricestr, scorestr
                ,datestr,isbNstr,linkstr,contentstr);
        List<bookmodel> bookmodelid=queryByName(namestr);
        model.setId(bookmodelid.get(0).getId());
        mbooksModelDao.update(model);
        mbooksModelDao.updateInTx();
    }

    public void deletebookInfo (bookmodel model) {
        mbooksModelDao.deleteByKey(model.getId());
    }
}