pipeline {

    environment {
        driver_path = "src/test/resources/linux/86/chromedriver"
        valid_login = "standard_user"
        valid_password = "secret_sauce"
    }

    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

//     parameters {
//         gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
//     }

    parameters {
        string name: 'BRANCH', defaultValue: 'master'
    }

    stages {

        stage('Environment') {
            steps {
                sh 'echo "driver_path is $driver_path"'
                sh 'echo "valid_login is $valid_login"'
                sh 'echo "valid_password is $valid_password"'
            }
        }

        stage('tests') {
            steps {
                // Get some code from a GitHub repository
                git branch: '$BRANCH', url: 'https://github.com/RomanShcherbich/AQA10-lesson-page-object-demo.git'

                // Run Maven on a Unix agent.
                sh "mvn clean test -Dmaven.test.failure.ignore=true -Dmaven.compiler.source=11 -Dmaven.compiler.target=11"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('reports') {
            steps {
                script {
                     allure([
                             includeProperties: false,
                             jdk: '',
                             properties: [],
                             reportBuildPolicy: 'ALWAYS',
                             results: [[path: 'target/allure-results']]
                     ])
                }
            }
        }

    }
}
