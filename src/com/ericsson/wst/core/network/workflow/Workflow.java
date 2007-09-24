/**
 * Workflow.java
 * Sep 13, 2007
 */
package com.ericsson.wst.core.network.workflow;

import com.ericsson.wst.core.network.connection.Connection;

/**
 * @author ehonlia
 * 
 */
public interface Workflow
{
    Communicator getCommunicator();

    Class<? extends Connection> getConnectionClass();

    void login(String host, int port);

    void logout();
}
