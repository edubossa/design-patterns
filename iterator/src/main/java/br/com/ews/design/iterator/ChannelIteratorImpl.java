package br.com.ews.design.iterator;

import java.util.List;

public class ChannelIteratorImpl implements ChannelIterator {

	private ChannelTypeEnum type;
	private List<Channel> channels;
	private int position;
	
	public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> channels) {
		this.type = type;
		this.channels = channels;
	}

	@Override
	public boolean hasNext() {
		
		while(position < channels.size()) {
			
			Channel c = channels.get(position);
			
			if(c.getType().equals(type) || type.equals(ChannelTypeEnum.ALL)) {
				return true;
			} else {
				position++;
			}
		}
		
		return false;
	}

	@Override
	public Channel next() {
		Channel c = channels.get(position);
		position++;
		return c;
	}

}
