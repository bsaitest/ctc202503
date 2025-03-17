import { shallowMount } from '@vue/test-utils';
import axios from 'axios';
import Lmsscs0100 from '@/components/Lmsscs0100.vue';

jest.mock('axios');

describe('Lmsscs0100.vue', () => {
  let wrapper;

  beforeEach(() => {
    wrapper = shallowMount(Lmsscs0100);
  });

  afterEach(() => {
    jest.clearAllMocks();
  });

  it('初期表示処理が正しく実行されること', async () => {
    const mockData = {
      employeeId: 'testEmployeeId',
      companyId: 'testCompanyId',
      organizationId: 'testOrgId'
    };
    axios.post.mockResolvedValue({ data: mockData });

    await wrapper.vm.initializeScreen();

    expect(wrapper.vm.loginInfo).toEqual(mockData);
    expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/init');
  });

  it('社員IDが入力されていない場合、学習者検索TOPへボタンが無効化されること', () => {
    wrapper.setData({ employeeIdInput: '' });

    expect(wrapper.find('button.search-button').attributes('disabled')).toBe('disabled');
  });

  it('社員IDが入力されている場合、学習者検索TOPへボタンが有効化されること', () => {
    wrapper.setData({ employeeIdInput: 'testEmployeeId' });

    expect(wrapper.find('button.search-button').attributes('disabled')).toBeUndefined();
  });

  it('学習者検索TOPへボタンクリック処理が正しく実行されること', async () => {
    wrapper.setData({ employeeIdInput: 'testEmployeeId' });
    axios.post.mockResolvedValue({});

    await wrapper.vm.navigateToSearch();

    expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/navigateToSearch', { employeeId: 'testEmployeeId' });
    // ルート遷移の確認
    expect(wrapper.vm.$router.push).toHaveBeenCalledWith('/LMSSCS0200');
  });

  it('要検討リストへボタンクリック処理が正しく実行されること', async () => {
    wrapper.setData({ employeeIdInput: 'testEmployeeId' });
    axios.post.mockResolvedValue({});

    await wrapper.vm.navigateToReviewList();

    expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/navigateToReviewList', { employeeId: 'testEmployeeId' });
    // ルート遷移の確認
    expect(wrapper.vm.$router.push).toHaveBeenCalledWith('/LMSSCS0400');
  });

  it('ログアウトボタンクリック処理が正しく実行されること', async () => {
    axios.post.mockResolvedValue({});

    await wrapper.vm.logout();

    expect(axios.post).toHaveBeenCalledWith('/lmsscs0100/logout');
    expect(wrapper.vm.loginInfo).toEqual({
      employeeId: '',
      companyId: '',
      organizationId: ''
    });
  });
});