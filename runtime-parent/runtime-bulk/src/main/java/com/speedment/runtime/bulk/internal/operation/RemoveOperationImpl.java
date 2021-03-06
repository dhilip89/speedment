/**
 *
 * Copyright (c) 2006-2017, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.runtime.bulk.internal.operation;

import com.speedment.runtime.bulk.RemoveOperation;
import com.speedment.runtime.core.manager.Manager;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 *
 * @author Per Minborg
 * @param <ENTITY> type
 */
public final class RemoveOperationImpl<ENTITY> extends AbstractOperation<ENTITY> implements RemoveOperation<ENTITY> {

    private final List<Predicate<? super ENTITY>> predicates;

    public RemoveOperationImpl(
        final Manager<ENTITY> manager,
        final List<Predicate<? super ENTITY>> predicates
    ) {
        super(Type.REMOVE, manager);
        this.predicates = new ArrayList<>(requireNonNull(predicates));
    }

    @Override
    public Stream<Predicate<? super ENTITY>> predicates() {
        return predicates.stream();
    }

}
