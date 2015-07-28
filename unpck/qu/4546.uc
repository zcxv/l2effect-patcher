class 4546 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect5
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		bSizeScale=True
		EffectClass=Class'LineageEffect.wh_recharge_ta'
	End Object
	Desc="Quest 석판과의 교감" //Quest boards , and the sympathetic
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect5',SpecificStage=0)
}