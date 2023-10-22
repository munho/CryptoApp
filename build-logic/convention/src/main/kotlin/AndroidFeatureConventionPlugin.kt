import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("cryptocurrency.android.library")
                apply("cryptocurrency.android.hilt")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
//                add("implementation", project(":core:model"))
//                add("implementation", project(":core:designsystem"))
//                add("implementation", project(":core:data"))
//                add("implementation", project(":core:common"))
//                add("implementation", project(":core:domain"))
//
//                add("implementation", libs.findLibrary("coilCompose").get())

//                add("implementation", libs.findLibrary("androidxHiltNavigationCompose").get())
//                add("implementation", libs.findLibrary("accompanistNavigationAnimation").get())
//                add("implementation", libs.findLibrary("androidxLifecycleRuntimeCompose").get())
//                add("implementation", libs.findLibrary("androidxLifecycleViewModelCompose").get())
//
//                add("implementation", libs.findLibrary("kotlinxCoroutinesAndroid").get())
            }
        }
    }
}
