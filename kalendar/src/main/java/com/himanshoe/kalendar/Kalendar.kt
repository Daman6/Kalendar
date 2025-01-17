/*
 * Copyright 2022 Kalendar Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.himanshoe.kalendar

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.himanshoe.kalendar.color.KalendarColors
import com.himanshoe.kalendar.color.KalendarThemeColor
import com.himanshoe.kalendar.component.day.config.KalendarDayColors
import com.himanshoe.kalendar.component.day.config.KalendarDayDefaultColors
import com.himanshoe.kalendar.component.header.config.KalendarHeaderConfig
import com.himanshoe.kalendar.model.KalendarDay
import com.himanshoe.kalendar.model.KalendarEvent
import com.himanshoe.kalendar.model.KalendarType
import com.himanshoe.kalendar.ui.firey.KalendarFirey
import com.himanshoe.kalendar.ui.oceanic.KalendarOceanic
import kotlinx.datetime.LocalDate

@Composable
fun Kalendar(
    modifier: Modifier = Modifier,
    kalendarType: KalendarType = KalendarType.Oceanic(true),
    kalendarEvents: List<KalendarEvent> = emptyList(),
    kalendarThemeColors: List<KalendarThemeColor> = KalendarColors.defaultColors(),
    onCurrentDayClick: (KalendarDay, List<KalendarEvent>) -> Unit = { _, _ -> },
    kalendarDayColors: KalendarDayColors = KalendarDayDefaultColors.defaultColors(),
    kalendarHeaderConfig: KalendarHeaderConfig? = null,
    takeMeToDate: LocalDate? = null,
) {
    if (kalendarThemeColors.isEmpty() || kalendarThemeColors.count() < 12) throw Exception("KalendarThemeColor cannot be null or less than 12, If you want to use same color accors months pass kalendarThemeColor = KalendarThemeColor(values)")

    when (kalendarType) {
        is KalendarType.Oceanic -> KalendarOceanic(
            modifier = modifier.wrapContentHeight(),
            kalendarEvents = kalendarEvents,
            onCurrentDayClick = onCurrentDayClick,
            kalendarDayColors = kalendarDayColors,
            kalendarThemeColors = kalendarThemeColors,
            takeMeToDate = takeMeToDate,
            kalendarHeaderConfig = kalendarHeaderConfig,
            showWeekDays = kalendarType.showWeekDays

        )
        KalendarType.Firey -> {
            KalendarFirey(
                modifier = modifier.wrapContentHeight(),
                kalendarEvents = kalendarEvents,
                onCurrentDayClick = onCurrentDayClick,
                kalendarDayColors = kalendarDayColors,
                kalendarThemeColors = kalendarThemeColors,
                takeMeToDate = takeMeToDate,
                kalendarHeaderConfig = kalendarHeaderConfig
            )
        }
    }
}

@Composable
fun Kalendar(
    modifier: Modifier = Modifier,
    kalendarThemeColor: KalendarThemeColor,
    kalendarType: KalendarType = KalendarType.Oceanic(true),
    kalendarEvents: List<KalendarEvent> = emptyList(),
    onCurrentDayClick: (KalendarDay, List<KalendarEvent>) -> Unit = { _, _ -> },
    kalendarDayColors: KalendarDayColors = KalendarDayDefaultColors.defaultColors(),
    kalendarHeaderConfig: KalendarHeaderConfig? = null,
    takeMeToDate: LocalDate? = null,
) {
    when (kalendarType) {
        is KalendarType.Oceanic -> KalendarOceanic(
            modifier = modifier.wrapContentHeight(),
            kalendarEvents = kalendarEvents,
            onCurrentDayClick = onCurrentDayClick,
            kalendarDayColors = kalendarDayColors,
            kalendarThemeColor = kalendarThemeColor,
            takeMeToDate = takeMeToDate,
            kalendarHeaderConfig = kalendarHeaderConfig,
            showWeekDays = kalendarType.showWeekDays
        )
        KalendarType.Firey -> {
            KalendarFirey(
                modifier = modifier.wrapContentHeight(),
                kalendarEvents = kalendarEvents,
                onCurrentDayClick = onCurrentDayClick,
                kalendarDayColors = kalendarDayColors,
                kalendarThemeColor = kalendarThemeColor,
                takeMeToDate = takeMeToDate,
                kalendarHeaderConfig = kalendarHeaderConfig
            )
        }
    }
}
