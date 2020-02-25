import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project


object Versions {
  val java = JavaVersion.VERSION_1_8.toString()
  val springBoot = "2.2.4.RELEASE"
}
