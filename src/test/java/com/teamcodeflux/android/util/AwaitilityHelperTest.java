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

package com.teamcodeflux.android.util;

import android.widget.Spinner;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;

import static com.teamcodeflux.android.util.AwaitilityHelper.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

public class AwaitilityHelperTest {
    private TextView textView;

    private Spinner spinner;

    @Before
    public void setUp() {
        textView = mock(TextView.class);

        spinner = mock(Spinner.class);
    }

    @Test
    public void shouldReturnTrueIfTextViewIsNotEmpty() throws Exception {
        given(textView.getText()).willReturn("Hello, world!");

        assertThat(notBlank(textView).call(), equalTo(true));
    }

    @Test
    public void shouldReturnFalseIfTextViewIsBlank() throws Exception {
        given(textView.getText()).willReturn("");

        assertThat(notBlank(textView).call(), equalTo(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfTextViewIsNull() throws Exception {
        // TextView should not be null, so we throw an IllegalArgumentException instead of checking if null
        given(textView.getText()).willReturn(null);

        assertThat(notBlank(textView).call(), equalTo(false));
    }

    @Test
    public void shouldReturnTrueIfSpinnerHasContents() throws Exception {
        given(spinner.getCount()).willReturn(10);

        assertThat(notEmpty(spinner).call(), equalTo(true));
    }

    @Test
    public void shouldReturnFalseIfSpinnerDoesNotHaveContents() throws Exception {
        given(spinner.getCount()).willReturn(0);

        assertThat(notEmpty(spinner).call(), equalTo(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shoudThrowIllegalArgumentExceptionIfSpinnerIsNull() throws Exception {
        spinner = null;
        assertThat(notEmpty(spinner).call(), equalTo(false));
    }
}
