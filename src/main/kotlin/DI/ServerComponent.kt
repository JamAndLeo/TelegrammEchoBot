package DI

import dagger.Component
import server.Server


@Component(
    modules = [
        RetrofitModule::class
    ]
)

interface ServerComponent {
    fun getServer(): Server
}

