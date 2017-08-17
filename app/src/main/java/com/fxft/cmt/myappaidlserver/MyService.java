package com.fxft.cmt.myappaidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class MyService extends Service {

    private String[] studentNo = {"王1", "2", "王3", "王4", "王月4", "宋6"};
    private IBinder binder = new StudentQueryBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    class StudentQueryBinder extends StudentAidl.Stub {

        @Override
        public String getStudent(int no) throws RemoteException {
            int l = studentNo.length;
            if (l < 0) {
                no = 0;
            }
            if (no >= l) {
                no = l - 1;
            }
            return studentNo[no];
        }

    }


}
