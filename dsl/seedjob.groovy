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
    def repoUrl = "https://github.com/amenaafreen/springbootwebapp.git"
    def packageName = "job_package"

    createPackageJob(packageName, repoUrl)
}


buildPipelineJobs()
