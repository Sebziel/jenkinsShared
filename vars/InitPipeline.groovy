def call(body) {
    def pipelineParams = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    pipeline{
    agent any
    stages{
        stage('Params'){
            steps{
                script{
                    properties(
                        parameters {
                            booleanParam 'BoolFromGroovy'
                        }
                    )
                }
             }
        }     
        stage('Playbook-sleep-test'){
            steps{
                sh "ansible-playbook -i /var/lib/jenkins/Ansible/inventory /var/lib/jenkins/Ansible/test-playbook.yaml --tags template -e build_number=${BUILD_NUMBER} -e pom_platform_version=${params.PLATFORM_VERSION} -e pom_appl_version=${params.EXTENSIONS_VERSION}"
            }
        }
        stage('pingtest'){
            steps{
                sh 'ansible -i /var/lib/jenkins/Ansible/inventory -m ping ansibleSlave3'
            }
        }     
    }
}
}
}