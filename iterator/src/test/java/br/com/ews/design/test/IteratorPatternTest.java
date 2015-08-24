package br.com.ews.design.test;

import org.junit.Before;
import org.junit.Test;

import br.com.ews.design.iterator.Channel;
import br.com.ews.design.iterator.ChannelCollection;
import br.com.ews.design.iterator.ChannelCollectionImpl;
import br.com.ews.design.iterator.ChannelIterator;
import br.com.ews.design.iterator.ChannelTypeEnum;

public class IteratorPatternTest {
	
	private ChannelCollection channels = new ChannelCollectionImpl();
	
	@Before
	public void init() {	
		channels.addChannel(new Channel(98.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(100.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(101.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(102.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(99.3, ChannelTypeEnum.PORTUGUES));
        channels.addChannel(new Channel(103.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(104.5, ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(105.5, ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(106.5, ChannelTypeEnum.FRENCH));
        channels.addChannel(new Channel(99.7, ChannelTypeEnum.PORTUGUES));
		
	}

	@Test
	public void tesChannelstAll() {
		System.out.println("---------------[Channels ALL]--------------------------");
		ChannelIterator iterator = channels.iterator(ChannelTypeEnum.ALL);
		while(iterator.hasNext()) {
			Channel c = iterator.next();
			System.out.println(c);
		}
		
	}
	
	@Test
	public void testChannelsPostugues() {
		System.out.println();
		System.out.println("---------------[Channels Portugues]--------------------------");
		ChannelIterator iterator = channels.iterator(ChannelTypeEnum.PORTUGUES);
		while(iterator.hasNext()) {
			Channel c = iterator.next();
			System.out.println(c);
		}
	}
	
	@Test
	public void testChannelsIngles() {
		System.out.println();
		System.out.println("---------------[Channels ENGLISH]--------------------------");
		ChannelIterator iterator = channels.iterator(ChannelTypeEnum.ENGLISH);
		while(iterator.hasNext()) {
			Channel c = iterator.next();
			System.out.println(c);
		}
	}

}
