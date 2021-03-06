/*******************************************************************************
 * Copyright 2013 Async4j Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.async4j.flow;

import org.async4j.Callback;
import org.async4j.flow.MultiEmiterFlowController.IterationCallback;

/**
 * {@link FlowController} factory interface. The flow controller is created with 
 *  {@link IterationCallback} which listen to iteration task end.
 * @author Amah AHITE
 *
 */
public interface FlowControllerFactory {
	public <E> FlowController<E> create(Callback<Void> iterationCallback);
}
