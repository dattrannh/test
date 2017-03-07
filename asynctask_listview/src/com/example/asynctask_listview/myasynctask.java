package com.example.asynctask_listview;

import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class myasynctask extends AsyncTask<Integer, Integer, ArrayList<Integer>> {

	
	Activity activityMain;
	ListView lv;
	ArrayAdapter<Integer> adapter;
	ArrayList<Integer>arr=new ArrayList<Integer>();
	public int fibonacci(int n){
		if(n==0) return 0;
		else if(n<=2) return 1;
		else  return fibonacci(n-1)+fibonacci(n-2);
	}
	
	public myasynctask(Activity ac) {
		activityMain=ac;
		lv=(ListView)activityMain.findViewById(R.id.listView1);
		adapter=new ArrayAdapter<Integer>(activityMain,android.R.layout.simple_list_item_1,arr);
		lv.setAdapter(adapter);
	}
	
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		Toast.makeText(activityMain, "bat dau", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected ArrayList<Integer> doInBackground(Integer... params) {
		int so=params[0];
		ArrayList<Integer> mangso=new ArrayList<Integer> ();
		for(int i=0;i<=so;i++){
			SystemClock.sleep(150);
			int f=fibonacci(i);
			mangso.add(f);
			publishProgress(f);	
		}
		return mangso; //trả về danh sách, nó sẽ được lưu trữ trong hàm
		 				//onPostExecute
	}
	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		 //lấy giá trị truyền từ publishProgress
		arr.add(values[0]);
		 //cập nhật lại giao diện
		 adapter.notifyDataSetChanged();
		
	}
	
	@Override
	protected void onPostExecute(ArrayList<Integer> result) {
		super.onPostExecute(result);
		int tong=0;
		 //vòng lặp để cộng dồn lại
		 for(int v : result)
		 {
		 tong+=v;
		 }
		 Toast.makeText(activityMain, "Tong ="+tong, Toast.LENGTH_LONG).show();
		 //cập nhật lên TextView
		 TextView txt=(TextView) activityMain.findViewById(R.id.textView1);
		 txt.setText(tong+"");
	}
}
