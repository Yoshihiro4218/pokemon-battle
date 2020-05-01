import {createLocalVue, mount, shallowMount} from '@vue/test-utils';
import LoginView from '@/views/LoginView';

const localVue = createLocalVue();

describe('LoginView UT', () => {
  const push = jest.fn();

  const $router = {
    push: jest.fn()
  };

  let wrapper;

  const createWrapper = async () => {
    wrapper = mount(LoginView, {
      localVue,
      mocks: {
        $router
      },
      stubs: ['router-link', 'router-view']
    });

    await wrapper.vm.$nextTick()
  };

  afterEach(() => {
    jest.restoreAllMocks();

    if (wrapper) {
      wrapper.destroy();
      wrapper = null
    }
  });

  it('未登録の方はこちらをクリックしたら登録画面に遷移すること', async () => {
    await createWrapper();
    wrapper.find('#new-user').trigger('click');
    await wrapper.vm.$nextTick();

    expect(push).toHaveBeenCalledWith('/userRegisterForm');
  });
});