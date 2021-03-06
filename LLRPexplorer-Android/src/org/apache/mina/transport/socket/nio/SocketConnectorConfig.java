/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.apache.mina.transport.socket.nio;

import org.apache.mina.common.IoConnectorConfig;
import org.apache.mina.common.RuntimeIOException;
import org.apache.mina.common.support.BaseIoConnectorConfig;

/**
 * An {@link IoConnectorConfig} for {@link SocketConnector}.
 *
 * @author The Apache Directory Project (mina-dev@directory.apache.org)
 * @version $Rev: 587373 $, $Date: 2007-10-23 11:54:05 +0900 (Tue, 23 Oct 2007) $
 */
public class SocketConnectorConfig extends BaseIoConnectorConfig {
    private SocketSessionConfig sessionConfig = new SocketSessionConfigImpl();

    /**
     * Creates a new instance.
     *
     * @throws RuntimeIOException if failed to get the default configuration
     */
    public SocketConnectorConfig() {
    }

    public SocketSessionConfig getSessionConfig() {
        return sessionConfig;
    }
}
