package ext

import com.google.inject.Injector
import net.runelite.client.RuneLite
import kotlin.reflect.KClass

object ExtUtil {
    /**
     * This is NOT fail safe and may cause crashes if it fails to get the instance, this is by design.
     * it allows us to do calls like `val client = Client::class.getInstance()`
     * It's not any shorter than using the Inject annotation generally but this is better for Ext
     */
    inline fun<reified T : Any> KClass<T>.getInstance(injector: Injector = RuneLite.getInjector()): T {
        return injector.getInstance(T::class.java) as T
    }
}