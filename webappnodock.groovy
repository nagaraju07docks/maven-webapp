job('webapp Docker example') {
    scm {
        git('git://github.com/nagaraju07docks/maven-webapp.git', 'master') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@gmail.com')
        }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        maven {
            goals('clean package')
            }
        }
    }
}
