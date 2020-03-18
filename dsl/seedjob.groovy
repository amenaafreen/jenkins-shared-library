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
    def repoUrl = "https://gitlab.mynisum.com/amenaafreen/spring-boot-app.git"
    def packageName = "job_package"
    def testName = "job_test"

    createPackageJob(packageName, repoUrl)
    createTestJob(testName, repoUrl)
}

buildPipelineJobs()
