/**
 * Workflow.java
 * Sep 13, 2007
 */
package com.ericsson.wst.core.network.workflow;

/**
 * @author ehonlia
 * 
 */
public interface Workflow
{
    Communicator getCommunicator();

    Class<?> getConnectionClass();

    void login(String host);

    void logout();
}
