package com.tutorials.photon.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.tutorials.photon.ui.theme.network.School
import com.tutorials.photon.ui.theme.network.Service
import com.tutorials.photon.ui.theme.viewModel.SchoolViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class SchoolViewModelTest {

    lateinit var viewModel: SchoolViewModel

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val dispatcher = StandardTestDispatcher()

    @Mock
    val service: Service = mock(Service::class.java)

    @Mock
    lateinit var dataObserver: Observer<Response<List<School>>>

    @Before
    fun setup() {
        viewModel = SchoolViewModel(service = service)
        viewModel.schoolData.observeForever(dataObserver)
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `TestGetSchoolReturnsSuccessfulResponse`() = runBlocking {
        `when`(service.getSchool()).thenReturn(Response.success(getValidData()))
        viewModel.getSchoolData()
        dispatcher.scheduler.runCurrent()
        Assert.assertEquals(true, service.getSchool().isSuccessful)
        Assert.assertEquals("name", service.getSchool().body()?.get(0)?.name)
    }

    @Test
    fun `Test GetSchool Return Error`() = runBlocking {
        `when`(service.getSchool()).thenReturn(Response.error(500, ResponseBody.create(null, "Error")))
        viewModel.getSchoolData()
        dispatcher.scheduler.runCurrent()
        Assert.assertEquals(false, service.getSchool().isSuccessful)
    }

    private fun getValidData(): List<School> {
        return listOf(
            School(
                name = "name",
                overview = "overview",
                academicopportunities1 = "academicopportunities1",
                academicopportunities2 = "academicopportunities2"
            ),
            School(
                name = "name 2",
                overview = "overview 2 ",
                academicopportunities1 = "academicopportunities1 -- 2",
                academicopportunities2 = "academicopportunities2 -- 2"
            )
        )
    }
}