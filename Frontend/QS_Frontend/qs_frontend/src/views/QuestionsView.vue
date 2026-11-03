
<template>
  <main>
    <h1>Questions</h1>

    <p v-if="errorMessage">
      {{ errorMessage }}
    </p>

    <section v-for="question in questions"
             :key="question.questionId">
      <h3>{{ question.question }}</h3>

      <div v-for="answer in question.options"
           :key="answer">
        <label>
          <input type="radio"
                 :name="'question-' + question.questionId"
                 :value="answer"
                 v-model="userAnswers[question.questionId]" />
          {{ answer }}
        </label>
      </div>
    </section>
    <button @click="sendAnswers">Submit</button>
    <p v-if="score !== null">
      Your score: {{ score }} / {{ questions.length }}
    </p>
  </main>
</template>

<script setup>
  import { ref, onMounted } from 'vue'

  import {
    getQuestions,
    submitAnswers as submitAnswersService
  } from '../services/QuestionService'

  const questions = ref([])
  const quizId = ref('')
  const userAnswers = ref({})
  const errorMessage = ref('')
  const score = ref(null)

  async function sendAnswers() {
    const answers = Object.entries(userAnswers.value).map(
      ([questionId, answer]) => ({
        questionId: Number(questionId),
        userAnswer: answer
      })
    )

    const submission = {
      quizId: quizId.value,
      userAnswers: answers
    }

    try {
      const response = await submitAnswersService(submission)

      score.value = response

      console.log('Score:', response)
    } catch (error) {
      console.error('Failed to submit answers:', error)
      errorMessage.value = 'Answers could not be submitted'
    }
  }

  onMounted(async () => {
    try {
      const quiz = await getQuestions()

      quizId.value = quiz.quizId
      questions.value = quiz.questions
    } catch (error) {
      console.error('Error fetching questions:', error)
      errorMessage.value = 'Questions could not be loaded'
    }
  })
</script>

<style scoped>
  main {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }

  h1 {
    text-align: center;
    margin-bottom: 20px;
  }

  section {
    margin-bottom: 20px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
  }

  h3 {
    margin-bottom: 10px;
  }

  label {
    display: block;
    margin-bottom: 5px;
  }

  button {
    display: block;
    margin: 20px auto;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
  }
</style>
