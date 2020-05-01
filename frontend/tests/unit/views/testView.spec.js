import {createLocalVue, shallowMount} from '@vue/test-utils';
import Vue from 'vue';
import TestView from '@/views/TestView';

// jest.mock('@/service/stack.example', () => jest.fn().mockImplementation(() => ({
//   items: [],
//   push(input) { this.items.push(input); },
//   pop: () => 'testPop',
//   peek: () => 'testPeek',
//   getCount: () => 123,
// })));

describe('TestView UT', () => {
  let target = null;

  beforeEach(() => {
    const localVue = createLocalVue()
    localVue.filter('moneyDelemiter', function (val) {
      return Number(val).toLocaleString(); //3桁区切りでカンマをつける
    });
    target = shallowMount(TestView, {localVue});
  });

  // it('inputを入力したとき、データに入力されるか', () => {
  //   target.find('input').setValue('testText');
  //
  //   expect(target.vm.inputData).toEqual('testText');
  // });

  it('文言確認', () => {
    const actual = target.find('#for-test').text();

    expect(actual).toEqual('カイリュー逆鱗発動！');
  });

  it('test-price確認', () => {
    const actual = target.find('#test-price').text();

    expect(actual).toEqual('123,456円');
  });
});