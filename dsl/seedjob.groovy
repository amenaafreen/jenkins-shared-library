def createPackageJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
                        }
                    }
                }
                scriptPath("Jenkinsfile")
            }
        }
    }
}

def createTestJob(jobName, repoUrl) {
    pipelineJob(jobName) {
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(repoUrl)
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
    def testName = "job_test"

    createPackageJob(packageName, repoUrl)
    createTestJob(testName, repoUrl)
}

buildPipelineJobs()
