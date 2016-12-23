/**
 * &copy; 2016 VCE Company, LLC. All rights reserved.
 * VCE Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.context.builder;

import com.dell.cpsd.common.rabbitmq.annotation.MessageContentType;
import com.dell.cpsd.common.rabbitmq.annotation.opinions.MessageExchangeType;
import com.dell.cpsd.common.rabbitmq.annotation.stereotypes.MessageStereotype;
import com.dell.cpsd.common.rabbitmq.context.MessageDescription;
import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * &copy; 2016 VCE Company, LLC. All rights reserved.
 * VCE Confidential/Proprietary Information
 * </p>
 *
 * @since SINCE-TBD
 */
public class MessageDescriptionFactoryTest
{
    @Test
    public void testCreate()
    {
        MessageDescriptionFactory factory = new MessageDescriptionFactory();
        MessageDescription description = factory.createDescription(TestRequestMessage.class);

        Assert.assertEquals("test.message.consumer", description.getType());
        Assert.assertEquals(TestRequestMessage.class, description.getMessageClass());
        Assert.assertEquals("correlationId", description.getCorrelationIdProperty());
        Assert.assertEquals("reply-to", description.getReplyToProperty());

        Assert.assertEquals("exchange.test", description.getExchange());
        Assert.assertEquals(MessageExchangeType.TOPIC, description.getExchangeType());

        Assert.assertEquals("binding.base", description.getConsumerBindingBase());
        Assert.assertEquals(MessageStereotype.REQUEST, description.getStereotype());
        Assert.assertEquals(MessageContentType.CLEAR, description.getContentType());
    }
}