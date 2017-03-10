package dynamic;
public class Test {
	public static void main(String[] args) {
		Proxy proxy=new Proxy();
		TimeBookInterface time=(TimeBookInterface)proxy.getInstance(new TimeBook());
		time.doAuditing();
		TimeAccountInterface t=(TimeAccountInterface)proxy.getInstance(new TimeAccount());
		t.doAccount();
	}
}
