
public class Client {
	public static void main(String[] args) {
		PeoPleNewsPaper paper=new PeoPleNewsPaper();
		SubHuman xiaoming=new SubHuman("С��");
		SubHuman yehongyu=new SubHuman("Ҷ����");
		SubHuman dashixiong=new SubHuman("��ʦ��");
		
		paper.registerSubscriber(xiaoming);
		paper.registerSubscriber(yehongyu);
		paper.registerSubscriber(dashixiong);
		System.out.println("-----���±�ֽ�ˣ���ʼ����ֽ");
		paper.sendPaper();
		System.out.println("-----С��ȡ������");
		paper.removeSubscriber(xiaoming);
		System.out.println("-----���±�ֽ�ˣ���ʼ����ֽ");
		paper.sendPaper();
		
	}
}
