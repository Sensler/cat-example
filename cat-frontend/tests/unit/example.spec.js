import { expect } from 'chai'
import AddCat from '@/views/AddCat.vue'

describe('AddCat', () => {
  it('sets the correct default data', () => {
    expect(typeof AddCat.data).to.equal('function')
    const defaultData = AddCat.data()
    expect(defaultData.name).to.equal('')
    expect(defaultData.color).to.equal('#000000')
  })
})
