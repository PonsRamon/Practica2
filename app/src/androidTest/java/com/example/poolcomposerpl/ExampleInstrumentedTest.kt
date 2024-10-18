package com.example.poolcomposerpl

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import android.content.Intent

import org.junit.Before
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiObjectNotFoundException
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Assert.assertEquals


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.poolcomposerpl", appContext.packageName)
    }
}

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class EjemploTest { private val APP_PACKAGE
        ="com.pasantiago.poolpass" // Paquete de la aplicacion
    private val LAUNCH_TIMEOUT = 5000L
    private lateinit var mDevice: UiDevice
    @Before
    fun setUp() {
// Inicializa el UiDevice para comunicarse con el dispositivo/emulador.
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
// Presiona el botón de inicio para asegurarse de estar en la pantalla principal.
        mDevice.pressHome()
// Inicia la aplicación.
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = context.packageManager.getLaunchIntentForPackage(APP_PACKAGE)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) // Limpia tareas anteriores.
        context.startActivity(intent)
// Espera a que la aplicación se abra.
        mDevice.wait(Until.hasObject(By.pkg(APP_PACKAGE).depth(0)), LAUNCH_TIMEOUT)
    }
    @Test
    @Throws(UiObjectNotFoundException::class)
    fun validarExisteTextField() {
        var textField = mDevice.findObject(UiSelector().resourceId("$APP_PACKAGE:id/editTextMetros"))
// Verifica si el cuadro de texto existe.
        val actualText = textField.text
// Verifica si el cuadro de texto tiene el valor esperado.
        assertEquals("El cuadro de texto no está presente", true, textField.exists())
    }
}