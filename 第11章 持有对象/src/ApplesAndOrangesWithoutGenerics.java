import java.util.ArrayList;

public class ApplesAndOrangesWithoutGenerics {
	public static void main(String[] args) {
		ArrayList<Apple> apples=new ArrayList<Apple>();
		for(int i=0;i<3;i++){
			apples.add(new Apple());
		}
		for(int i=0;i<apples.size();i++){
			System.out.println(apples.get(i).id());
		}
		for(Apple c:apples){
			System.out.println(c.id());
		}
	}
}
