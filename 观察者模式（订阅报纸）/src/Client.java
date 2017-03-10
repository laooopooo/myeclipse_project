
public class Client {
	public static void main(String[] args) {
		PeoPleNewsPaper paper=new PeoPleNewsPaper();
		SubHuman xiaoming=new SubHuman("小明");
		SubHuman yehongyu=new SubHuman("叶红鱼");
		SubHuman dashixiong=new SubHuman("大师兄");
		
		paper.registerSubscriber(xiaoming);
		paper.registerSubscriber(yehongyu);
		paper.registerSubscriber(dashixiong);
		System.out.println("-----有新报纸了，开始发报纸");
		paper.sendPaper();
		System.out.println("-----小明取消订阅");
		paper.removeSubscriber(xiaoming);
		System.out.println("-----有新报纸了，开始发报纸");
		paper.sendPaper();
		
	}
}
