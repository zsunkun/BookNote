package com.example.tools;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.booknote.R;

public class BookData {

	public static List<JSONObject> mData;

	public static List<JSONObject> getBookData() {
		if (mData != null)
			return mData;
		mData = new ArrayList<JSONObject>();
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("headImage", R.drawable.head_1);
			jsonObject.put("name", "Johnson");
			jsonObject.put("action", "摘抄");
			jsonObject.put("time", "1分钟前");
			jsonObject.put("text", "1、记者，凭什么拥有一个节日？\n2、每一个动作都是ing\n");
			jsonObject.put("showCard", false);
			jsonObject.put("bookImage", R.drawable.book_1);
			jsonObject.put("cardBookAuthor", "敬一丹 ");
			jsonObject.put("cardBookName", "我遇到你");
			jsonObject.put("cardBookPublish", "长江文艺出版社");
			jsonObject.put("bookName", "《我遇到你》");
			jsonObject.put("pageCount", "216");
			jsonObject.put("bookDetail", "今年4月，60岁的敬一丹从央视退休，写下回忆性文字，回顾...");
			mData.add(jsonObject);
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("headImage", R.drawable.head_2);
			jsonObject2.put("name", "Young");
			jsonObject2.put("action", "摘抄");
			jsonObject2.put("time", "5分钟前");
			jsonObject2
					.put("text",
							"1、每天有一千个太阳升起，我们只看见其中的一个，因为我们固着单一的思考\n2、世界上最有名，却最不为人知的艺术家：每个人都知道她的名字，可没有人知道她做了什么\n3、聆听火燃烧的声音在地球的中心");
			jsonObject2.put("showCard", true);
			jsonObject2.put("bookImage", R.drawable.book_2);
			jsonObject2.put("cardBookAuthor", "[美]小野洋子 ");
			jsonObject2.put("cardBookName", "想象你是一颗飞翔的种子");
			jsonObject2.put("cardBookPublish", "新星出版社");
			jsonObject2.put("bookName", "《想象你是一颗飞翔的种子》");
			jsonObject2.put("pageCount", "19");
			jsonObject2.put("bookDetail", "聆听火燃烧的声音,在地球的中心。想象给城市里所有的建筑涂上...");
			mData.add(jsonObject2);
		} catch (JSONException e) {
		}
		return mData;
	}
}
