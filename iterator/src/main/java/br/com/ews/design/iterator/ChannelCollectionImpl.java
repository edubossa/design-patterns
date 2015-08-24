package br.com.ews.design.iterator;

import java.util.ArrayList;
import java.util.List;

public class ChannelCollectionImpl implements ChannelCollection {
	
	private List<Channel> channels;
	
	public ChannelCollectionImpl() {
		channels = new ArrayList<>();
	}

	@Override
	public void addChannel(Channel c) {
		channels.add(c);
	}

	@Override
	public void removeChannel(Channel c) {
		channels.remove(c);
	}

	@Override
	public ChannelIterator iterator(ChannelTypeEnum type) {
		return new ChannelIteratorImpl(type, channels);
	}

}
