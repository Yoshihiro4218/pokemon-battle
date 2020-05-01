import { shallowMount } from '@vue/test-utils';
import Vue from 'vue';
import TestView from '@/views/TestView';

// jest.mock('@/service/stack.example', () => jest.fn().mockImplementation(() => ({
//   items: [],
//   push(input) { this.items.push(input); },
//   pop: () => 'testPop',
//   peek: () => 'testPeek',
//   getCount: () => 123,
// })));

describe('ExampleStack Page UT', () => {
  let target = null;

  beforeEach(() => {
    target = shallowMount(TestView, {Vue});
    Vue.filter('moneyDelemiter', function(val){
      return Number(val).toLocaleString(); //3桁区切りでカンマをつける
    });
  });

  // it('inputを入力したとき、データに入力されるか', () => {
  //   target.find('input').setValue('testText');
  //
  //   expect(target.vm.inputData).toEqual('testText');
  // });

  it('test-price確認', () => {
    const actual = target.find('#for-test').text();
    expect(actual).toEqual('カイリュー逆鱗発動！');

    expect(1).toEqual(1);
  });
});