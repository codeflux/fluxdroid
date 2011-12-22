/*
 * Copyright 2011 CodeFlux, Inc <info@teamcodeflux.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.teamcodeflux.android.adapter;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public abstract class AbstractSimpleAdapterBuilder<T> implements SimpleAdapterBuilder {
    protected Context context;
    protected List<T> data;

    public AbstractSimpleAdapterBuilder(final Context context, final List<T> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public SimpleAdapter build() {
        return new SimpleAdapter(context, data(data), resource(), from(), to());
    }

    protected abstract List<? extends Map<String, ?>> data(List<T> data);
    protected abstract int resource();
    protected abstract String[] from();
    protected abstract int[] to();
}
