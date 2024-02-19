package com.tutorials.photon

import androidx.test.core.app.ActivityScenario.ActivityAction
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tutorials.photon.ui.theme.network.School
import com.tutorials.photon.ui.theme.viewModel.SchoolViewModel
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.`when`
import retrofit2.Response

//@RunWith(AndroidJUnit4::class)
//class MainComposableTest {
//
//    @Rule
//    var mMainActivityRule = ActivityScenarioRule(MainActivity::class.java)
//
//    @Mock
//    val viewModel: SchoolViewModel = mock(SchoolViewModel::class.java)
//
//    @Before
//    fun setUp() {
//
//    }
//
//    @After
//    fun teardown() {
//        mMainActivityRule.scenario.close()
//    }
//
//    @Test // this test is failing now
//    fun verifyActivityOpens() {
//
//        mMainActivityRule.getScenario().onActivity(
//            ActivityAction<MainActivity> { activity: MainActivity? ->
//                `when`(
//                    viewModel.schoolData.value
//                ).thenReturn(getValidData())
//            }
//        )
//
//        onView(ViewMatchers.withText("School")).check(
//            ViewAssertions.matches(
//                ViewMatchers.isDisplayed()
//            )
//        )
//    }
//
//}
//
//private fun getValidData(): Response<List<School>> {
//    return Response.success(
//        listOf(
//            School(
//                name = "name",
//                overview = "overview",
//                academicopportunities1 = "academicopportunities1",
//                academicopportunities2 = "academicopportunities2"
//            ),
//            School(
//                name = "name 2",
//                overview = "overview 2 ",
//                academicopportunities1 = "academicopportunities1 -- 2",
//                academicopportunities2 = "academicopportunities2 -- 2"
//            )
//        )
//    )
//}
