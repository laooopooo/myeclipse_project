public interface INewsPaper {
	void registerSubscriber(ISubscribe subscribe);

	void removeSubscriber(ISubscribe subscribe);

	void sendPaper();
}
