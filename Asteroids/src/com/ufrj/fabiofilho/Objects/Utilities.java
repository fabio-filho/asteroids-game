package com.ufrj.fabiofilho.Objects;

/**
 * Created by fabiofilho on 6/1/16.
 */
public class Utilities {

    public static void sleep(int mTimer){

        try {
            Thread.sleep(mTimer);

        }catch (Exception o){
            Utilities.log(o.toString());
        }
    }


    public static String log(String mMessage){

        StackTraceElement mStackTraceElement = new Throwable().getStackTrace()[1];

        String mFinalMessage = mStackTraceElement.getClassName()+" . "+ mStackTraceElement.getMethodName()+" () -> \n" + mMessage +"\n\n";

        System.out.print(mFinalMessage);

        return mFinalMessage;
    }

}