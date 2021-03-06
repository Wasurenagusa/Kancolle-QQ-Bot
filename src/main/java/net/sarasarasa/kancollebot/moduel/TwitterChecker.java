package net.sarasarasa.kancollebot.moduel;

import java.util.ArrayList;
import java.util.List;

import com.scienjus.smartqq.client.SmartQQClient;
import com.scienjus.smartqq.model.Group;
import net.sarasarasa.kancollebot.main.Application;

/**
 * @author AyagiKei
 * @url https://github.com/Ayagikei
 *
 **/

public class TwitterChecker implements Runnable {

	private static List<Group> groupList = new ArrayList<>();
	private SmartQQClient client;

	public TwitterChecker(SmartQQClient client) {
		// TODO 自动生成的构造函数存根
		this.client = client;
		groupList = client.getGroupList();
	}

	private void printMessage(String meg) {
		for (Group e : groupList)
			client.sendMessageToGroup(e.getId(), meg);
	}

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(30000); // 睡眠半分钟后再次执行任务，模拟定时任务

				TwitterGetter twitterGetter = new TwitterGetter();
				String twitter;
				if ((twitter = twitterGetter.getTwitter(true)) != null)
					printMessage(twitter);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
