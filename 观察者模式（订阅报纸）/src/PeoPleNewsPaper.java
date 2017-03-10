import java.util.ArrayList;
import java.util.List;

public class PeoPleNewsPaper implements INewsPaper {
	private List<ISubscribe> subList = new ArrayList<ISubscribe>();

	@Override
	public void registerSubscriber(ISubscribe subscribe) {
		// TODO Auto-generated method stub
		subList.add(subscribe);
	}

	@Override
	public void removeSubscriber(ISubscribe subscribe) {
		// TODO Auto-generated method stub
		subList.remove(subscribe);
	}

	@Override
	public void sendPaper() {
		// TODO Auto-generated method stub
		for(ISubscribe sub : subList){
			sub.hasNewPaper();
		}
	}
}
