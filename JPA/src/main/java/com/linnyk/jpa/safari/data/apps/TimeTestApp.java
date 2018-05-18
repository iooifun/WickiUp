package com.linnyk.jpa.safari.data.apps;

import com.linnyk.jpa.safari.data.entities.TimeTest;
import com.linnyk.jpa.safari.data.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

public class TimeTestApp {

    @Test
    public void test() {
        final Session session = HibernateUtil.getSessionFactoryXML().openSession();
        session.beginTransaction();
        try{
            final TimeTest timeTest = new TimeTest(new Date());

            session.save(timeTest); //save

            session.getTransaction().commit();

            session.refresh(timeTest); //refresh

            System.out.println(timeTest);// TimeTest [
                                         //     timeTestId=2,
                                         //     datetimeColumn=2018-05-15 13:09:19.665,
                                         //     timestampColumn=2018-05-15 13:09:19.665,
                                         //     dateColumn=2018-05-15,
                                         //     timeColumn=13:09:19,
                                         //     sqlDatetimeColumn=2018-05-15 13:09:19.665,
                                         //     sqlTimestampColumn=2018-05-15 13:09:19.665,
                                         //     sqlDateColumn=2018-05-15,
                                         //     sqlTimeColumn=13:09:19]

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            HibernateUtil.getSessionFactoryXML().close();
        }
    }
}