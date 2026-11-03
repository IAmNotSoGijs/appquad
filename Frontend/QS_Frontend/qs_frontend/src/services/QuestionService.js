import api from '../api/axios'

export async function getQuestions() {
  try {
    const response = await api.get('/questions')
    return response.data
  } catch (error) {
    console.error('Error with fetching questions', error)
    throw error
  }
}
export async function submitAnswers(submission) {
  try {
    const response = await api.post(
      '/SumbitAnswers',
      submission
    )

    return response.data
  } catch (error) {
    console.error('Error with sending answers', error)
    throw error
  }
}
