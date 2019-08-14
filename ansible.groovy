job('webapp Docker example') {
    scm {
    	label('jennode')
        git('git://github.com/nagaraju07docks/maven-webapp.git', '*/master') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@gmail.com')
        }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        sshAgent('ansible-controller')
    }
    steps {
    	shell("cd /home/ansible/workspace/ansibleroles; git pull origin master; ansible-playbook -i 192.168.30.50, Docker-Install.yaml; ansible-playbook -i 192.168.30.50, Container-Start.yaml")
    }
  }
}
