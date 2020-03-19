def createPackageJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                        branches('master')
                        extensions {
                            cleanBeforeCheckout()
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}

def buildPipelineJobs() {
    def repoUrl = "https://gitlab.mynisum.com/amenaafreen/spring-boot-app.git"
    def packageName = "job_package"

    createPackageJob(packageName, repoUrl)
}


buildPipelineJobs()
