class 2177 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.it_scroll_of_escape_ta'
	End Object
	Desc="축복받은 아지트 귀환 주문서" //Blessed hideout return order
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
}