import { shallowMount } from '@vue/test-utils';
import axios from 'axios';
import Lmsscs0100 from '@/components/lmsscs0100/Lmsscs0100.vue';

jest.mock('axios');

describe('Lmsscs0100.vue', () => {
  let wrapper;

  beforeEach(() => {
    const mockAxios = {
      post: jest.fn().mockResolvedValue({
        data: {
          employeeId: 'e01',
          companyId: 'c01',
          organizationId: 'org01'
        }
      })
    };

    wrapper = shallowMount(Lmsscs0100, 
      {
        global: {
          mocks: {
            $axios: mockAxios,
            $router: {
              push: jest.fn()
            }

          },
          plugins: {
            axios: mockAxios
          }
        }
      }
    );

  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  it('初期表示処理が正しく実行されること', async () => {

    await wrapper.vm.$nextTick();
    let mockData = {
      employeeId: 'e01',
      companyId: 'c01',
      organizationId: 'org01'
    };
    expect(wrapper.vm.loginData).toEqual(mockData);
    // expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/init');
  });

  it('社員IDが入力されていない場合、学習者検索TOPへボタンが無効化されること', () => {
    wrapper.setData({ employeeIdInput: '' });

    expect(wrapper.find('button.search-button').attributes('disabled')).toBe('disabled');
  });

  it('社員IDが入力されている場合、学習者検索TOPへボタンが有効化されること', () => {
    wrapper.setData({ employeeIdInput: 'e01' });

    expect(wrapper.find('button.search-button').attributes('disabled')).toBeUndefined();
  });

  it('学習者検索TOPへボタンクリック処理が正しく実行されること', async () => {
    wrapper.setData({ employeeIdInput: 'e01' });
    axios.post.mockResolvedValue({});

    await wrapper.vm.navigateToSearch();

    expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/navigateToSearch', { employeeId: 'e02' });
    // ルート遷移の確認
    expect(wrapper.vm.$router.push).toHaveBeenCalledWith('/lmsscs0200');
  });

  it('要検討リストへボタンクリック処理が正しく実行されること', async () => {
    wrapper.setData({ employeeId: 'e02' });
    axios.post.mockResolvedValue({});

    await wrapper.vm.navigateToReviewList();

    expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/navigateToReviewList', { employeeId: 'e02' });
    // ルート遷移の確認
    expect(wrapper.vm.$router.push).toHaveBeenCalledWith('/lmsscs0400');
  });

  it('ログアウトボタンクリック処理が正しく実行されること', async () => {
    axios.post.mockResolvedValue({});

    await wrapper.vm.logout();

    expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/logout');
    expect(wrapper.vm.loginData).toEqual({
      employeeId: '',
      companyId: '',
      organizationId: ''
    });
  });
});